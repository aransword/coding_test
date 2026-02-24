import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class PokemonByNum implements Comparable<PokemonByNum> {
    int num;
    String name;

    public PokemonByNum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public int compareTo(PokemonByNum p) {
        return this.num - p.num;
    }
}

class PokemonByName implements Comparable<PokemonByName> {
    int num;
    String name;

    public PokemonByName(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public int compareTo(PokemonByName p) {
        return this.name.compareTo(p.name);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PokemonByNum[] pokedexSortByNum = new PokemonByNum[N + 1];
        PokemonByName[] pokedexSortByName = new PokemonByName[N + 1];
        for(int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            pokedexSortByNum[i] = new PokemonByNum(i, name);
            pokedexSortByName[i] = new PokemonByName(i, name);
        }

        Arrays.sort(pokedexSortByName, 1, N + 1, new Comparator<PokemonByName>() {
            @Override
            public int compare(PokemonByName p1, PokemonByName p2) {
                return p1.compareTo(p2);
            }
        });

        for(int i = 0; i < M; i++) {
            String question = br.readLine();
            if(question.matches("\\d+")) {
                int num = Integer.parseInt(question);
                int result = Arrays.binarySearch(pokedexSortByNum, 1, N + 1, new PokemonByNum(num, " "), Comparator.comparingInt(p -> p.num));
                sb.append(pokedexSortByNum[result].name).append('\n');
            } else {
                int result = Arrays.binarySearch(pokedexSortByName, 1, N + 1, new PokemonByName(0, question), Comparator.comparing(p -> p.name));
                sb.append(pokedexSortByName[result].num).append('\n');
            }
        }

        System.out.println(sb);
    }
}