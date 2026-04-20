package sofia.sitnikova.pr1.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class student
{
    @NotBlank(message = "Ім'я обов'язкове")
    private String name;

    @Min(value = 17, message = "Вік має бути більшим за 16")
    private int age;

    @Email(message = "Некоректний формат email")
    @NotBlank(message = "Email обов'язковий")
    private String email;
    private int id; // додала айді

    public student() {}

    public student(String name, int age, String email, int id)
    {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
