/*
package br.senai.model;

public class UserLoged {
    // Todas classes modelo foram importadas do último projeto.
    
    private static String idUsuario, nome, matricula, email;
    private static int mestre;
    private static boolean loged;

    public static void login(String idUsuario){
        UserLoged.idUsuario = idUsuario;

        UserLoged.nome = select(
                "usuario",
                new String[] {"nome"},
                "idUsuario = " + idUsuario
        ).get(0);

        UserLoged.matricula = select(
                "usuario",
                new String[] {"matricula"},
                "idUsuario = " + idUsuario
        ).get(0);

        UserLoged.email = select(
                "usuario",
                new String[] {"email"},
                "idUsuario = " + idUsuario
        ).get(0);

        UserLoged.mestre = Integer.parseInt(select(
                "usuario",
                new String[] {"mestre"},
                "idUsuario = " + idUsuario
            ).get(0)
        );

        connectUserToDatabase();
        UserLoged.loged = true;
    }

    public static void logout(){
        UserLoged.idUsuario = null;
        UserLoged.nome = null;
        UserLoged.matricula = null;
        UserLoged.email = null;
        UserLoged.mestre = 0;

        UserLoged.loged = false;

        DBHelper.exec("DELETE FROM userLoged");
    }

    public static void tryConnection(){
        ArrayList<String> idUsuArray = select(
                "userLoged",
                new String[] {"idUsuario"}
        );

        if(idUsuArray.size() > 0){
            UserLoged.idUsuario = idUsuArray.get(0);
            UserLoged.login(UserLoged.idUsuario);
        }
    }

    public static boolean isLoged() {
        tryConnection();
        return loged;
    }

    public static String getIdUsuario() { return UserLoged.idUsuario; }

    public static String getNome() { return UserLoged.nome; }

    public static String getMatricula() { return UserLoged.matricula; }

    public static String getEmail() { return UserLoged.email; }

    public static int getMestre() { return mestre; }
}
*/