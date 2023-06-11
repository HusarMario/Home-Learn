class Profile {

    private final String nickname;
    private final String password;
    private final int age;

    public Profile(String nickname, String password, int age) {
        this.nickname = nickname;
        this.password = password;
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}

