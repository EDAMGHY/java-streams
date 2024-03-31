package ex2;

import java.util.*;

public class App {
    public static void main(String[] args) {

        List<Employe> list = new ArrayList<Employe>(Arrays.asList(
                new Employe("John", "Finance", 7000),
                new Employe("Alice", "IT", 12000),
                new Employe("Bob", "HR", 9000)
        ));

        // la somme totale
        double sommeSalaires = list.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + sommeSalaires);
        divide();


        // Trier la liste
        list.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .forEach(System.out::println);
        divide();

        // Trouver l'employé avec le salaire le plus bas
        Optional<Employe> employeSalaireMinimum = list.stream()
                .min(Comparator.comparingDouble(Employe::getSalaire));
        employeSalaireMinimum.ifPresent(System.out::println);
        divide();

        // Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée
        double salaireSeuil = 10000;
        List<Employe> employesSalairesSup = list.stream()
                .filter(e -> e.getSalaire() > salaireSeuil)
                .toList();
        System.out.println("Employés avec un salaire supérieur à " + salaireSeuil + " : " + employesSalairesSup);
        divide();

        // Trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise
        Optional<Employe> employeSalaireMaximum = list.stream()
                .max(Comparator.comparingDouble(Employe::getSalaire));
        employeSalaireMaximum.ifPresent(System.out::println);
        divide();

        // Concaténer les noms de tous les employés
        String nomsConcatenes = list.stream()
                .map(Employe::getNom)
                .reduce("", (nom1, nom2) -> nom1 + ", " + nom2);
        System.out.println("Noms concaténés : " + nomsConcatenes);
        divide();

    }

    private static void divide() {
        System.out.println("\n-----------------------------------\n");
    }
}
