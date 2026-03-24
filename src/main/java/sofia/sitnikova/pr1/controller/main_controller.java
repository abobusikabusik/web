package sofia.sitnikova.pr1.controller;

import org.springframework.web.bind.annotation.*;
import sofia.sitnikova.pr1.model.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class main_controller
{
    private List<student> students = new ArrayList<>();
    private int nextId = 1;

    @GetMapping("/hello_world")
    public String helloWorld(Model model)
    {
        model.addAttribute("message", "hello world!!!");
        return "hello-world";
    }

    // Показати список студентів
    @GetMapping
    public String showStudents(Model model)
    {
        model.addAttribute("students", students);
        return "students";
    }

    // Показати форму додавання
    @GetMapping("/add")
    public String showForm(Model model)
    {
        model.addAttribute("student", new student());
        return "add-student";
    }

    // Обробка POST-запиту
    @PostMapping("/add")
    public String addStudent(@ModelAttribute student student)
    {
        if (student.getId() == 0)
        {
            // якщо ID нуль - це новий студент
            student.setId(nextId++);
            students.add(student);
        }
        else
        {
            // якщо ID вже є - оновлюємо старий запис
            students.removeIf(s -> s.getId() == student.getId());
            students.add(student);
        }
        return "redirect:/students";
    }

    // редагування інфи студентів
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model)
    {
        student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("student", student);
        return "add-student";
    }

    // видалення
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        students.removeIf(s -> s.getId() == id);
        return "redirect:/students";
    }
}
