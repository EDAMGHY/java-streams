package ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        // Liste de mots
        List<String> mots = Arrays.asList("Java", "Python", "JavaScript", "Ruby", "C++", "Swift");

        // Filtrer les mots qui contiennent la lettre "a"
        List<String> motsContenantA = mots.stream()
                .filter(s -> s.contains("a"))
                .toList();
        System.out.println("Mots contenant la lettre 'a': " + motsContenantA);

        // Filtrer les mots qui ont une longueur supérieure à 3 et les transformer en leur inverse
        List<String> motsInverse = mots.stream()
                .filter(s -> s.length() > 3)
                .map(s -> new StringBuilder(s).reverse().toString())
                .toList();
        System.out.println("Mots inversés de longueur supérieure à 3: " + motsInverse);

        // Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de ses caractères
        List<Character> caracteresAvecE = mots.stream()
                .filter(s -> s.contains("e"))
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .toList();
        System.out.println("Liste des caractères des mots contenant 'e': " + caracteresAvecE);

        // Transformer chaque chaîne en sa version en majuscules
        List<String> motsEnMajuscules = mots.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Mots en majuscules: " + motsEnMajuscules);

        // Convertir chaque chaîne en sa longueur
        List<Integer> longueursMots = mots.stream()
                .map(String::length)
                .toList();
        System.out.println("Longueurs des mots: " + longueursMots);

        // Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères
        List<Character> caracteres = mots.stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(c -> (char) c)
                .toList();
        System.out.println("Liste de caractères: " + caracteres);

        // Transformer chaque nom en une chaîne de la forme "Nom - Index"
        List<String> nomsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .toList();
        System.out.println("Noms avec index: " + nomsAvecIndex);
    }
}

