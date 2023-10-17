package com.mlk;

import com.mlk.Entities.Medecin;
import com.mlk.Entities.Patient;
import com.mlk.Entities.RendezVous;
import com.mlk.Repository.Bdd.MedecinRepository;
import com.mlk.Repository.Bdd.PatientRepository;
import com.mlk.Repository.Bdd.impl.MedecinRepoImpl;
import com.mlk.Repository.Bdd.impl.PatientRepoImpl;
import com.mlk.Repository.Core.Database;
import com.mlk.Repository.Core.MySQLImplMedecin;
import com.mlk.Repository.Core.MySQLImplPatient;
import com.mlk.Repository.Core.MySQLImplRv;
import com.mlk.Service.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Database databasePa = new MySQLImplPatient();
        Database db = new MySQLImplMedecin();
        Database rvRepo = new MySQLImplRv();

        PatientRepository patientRepository = new PatientRepoImpl(databasePa);
        PersonService personService = new PersonServiceImpl(patientRepository);

        MedecinRepository medecinRepository = new MedecinRepoImpl(db);
        MedecinService medecinService = new MedecinServiceImpl(medecinRepository);

        RvRepository rvRepository = new RvRepoImpl(rvRepo);
        RvService rvService = new RvServiceImpl(rvRepository);
        int choix;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-------App---------");
            System.out.println("1-Creer un patient");
            System.out.println("2-Creer un medecin");
            System.out.println("3-Planifier RV");
            System.out.println("4-Afficher RV du jour");
            System.out.println("5-Afficher RV Medecin du jour");
            System.out.println("6-Annuler RV");
            System.out.println("7-Quitter");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("Entrez le nom complet du patient : ");
                    String nomComplet = sc.nextLine();
                    System.out.println("Entrez les antécédents du patient (séparés par des virgules) : ");
                    String antecedentInput = sc.nextLine();
                    String[] antecedentsArray = antecedentInput.split(", ");
                    List<String> antecedent = new ArrayList<>(Arrays.asList(antecedentsArray));
                    String type = "patient";
                    Patient patient = new Patient(nomComplet, antecedent, type);
                    int rowCount = personService.add(patient);
                    if (rowCount > 0) {
                        System.out.println("Patient ajouté avec succès !");
                    } else {
                        System.out.println("Erreur lors de l'ajout du patient.");
                    }
                    break;
                case 2:
                    System.out.println("Entrez le nom complet du médecin : ");
                    String nomCompletMedecin = sc.nextLine();
                    System.out.println("Entrez la spécialité du médecin : ");
                    String specialite = sc.nextLine();
                    String typeMedecin = "medecin";
                    Medecin medecin = new Medecin(nomCompletMedecin, typeMedecin, specialite);
                    int rowCountMedecin = medecinService.add(medecin);
                    if (rowCountMedecin > 0) {
                        System.out.println("Médecin ajouté avec succès !");
                    } else {
                        System.out.println("Erreur lors de l'ajout du médecin.");
                    }
                    break;
                case 3:
                    System.out.println("Planifier un rendez-vous :");
                    System.out.println("Entrez l'ID du patient : ");
                    int idPatient = sc.nextInt();
                    sc.nextLine();
                    Patient patients = personService.show(idPatient);
                    if (patients != null) {
                        System.out.println("Patient trouvé : " + patients.getNomComplet());
                        System.out.println("Entrez l'ID du médecin : ");
                        int idMedecin = sc.nextInt();
                        sc.nextLine();
                        Medecin medecins = medecinService.show(idMedecin);
                        if (medecins != null) {
                            System.out.println("Médecin trouvé : " + medecins.getNomComplet());
                            System.out.println("Entrez la date du rendez-vous (yyyy-MM-dd) : ");
                            String dateInput = sc.nextLine();
                            System.out.println("Entrez l'heure du rendez-vous (HH:mm) : ");
                            String heureInput = sc.nextLine();
                            RendezVous rendezVous = new RendezVous();
                            rendezVous.setIdPatient(idPatient);
                            rendezVous.setIdMedecin(idMedecin);
                            int rowCountRv = rvService.add(rendezVous);
                            if (rowCountRv > 0) {
                                System.out.println("Rendez-vous planifié avec succès !");
                            } else {
                                System.out.println("Erreur lors de la planification du rendez-vous.");
                            }
                        } else {
                            System.out.println("Médecin introuvable. Assurez-vous d'entrer un ID de médecin valide.");
                        }
                    } else {
                        System.out.println("Patient introuvable. Assurez-vous d'entrer un ID de patient valide.");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }

        }while(choix!=7);
    }
}
