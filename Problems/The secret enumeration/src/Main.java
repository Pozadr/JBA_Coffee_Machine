public class Main {

    public static void main(String[] args) {
        int result = 0;
        Secret[] secrets = Secret.values();
        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith("STAR")) {
                result++;
            }
        }
        System.out.println(result);
    }
}

/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}
*/