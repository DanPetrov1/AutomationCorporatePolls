package system.current;

public class CurrentUser {
    private static int id;
    private static String name;
    private static String email;
    private static String password;

    public static int getId() { return id; }
    public static void setId(int id) { CurrentUser.id = id; }
    public static String getName() { return name; }
    public static void setName(String name) { CurrentUser.name = name; }
    public static String getEmail() { return email; }
    public static void setEmail(String email) { CurrentUser.email = email; }
    public static String getPassword() { return password; }
    public static void setPassword(String password) { CurrentUser.password = password; }
}
