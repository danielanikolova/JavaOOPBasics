package animals;

public class Animal implements soundProducible{

    private String name;
    private String age;
    private String gender;

    public Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(String age) {
        int ageNum = Integer.parseInt(age);

        if (age.trim().length()==0||ageNum<0){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.age = age;
    }

    private void setGender(String gender) {
        if (gender.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %s\n", this.name, this.age, this.gender));
        sb.append(this.produceSound()+"\n");
        return sb.toString();
    }
}
