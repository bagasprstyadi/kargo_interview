public class User {

    private String id;
    private String password;
    private int role;

    public User(String id, String password, int role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return this.id;
    }   

    public void setId(String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return this.password;
    }   

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return this.role;
    }   

    public void setRole(int role) {
        this.role = role;
    }
}