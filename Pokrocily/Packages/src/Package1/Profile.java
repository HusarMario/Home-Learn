package Package1;

public class Profile {
    private final String nickname;
    private final String password;

    public Profile(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
