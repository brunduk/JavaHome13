import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void querySimpleTaskTrue() {
        SimpleTask task = new SimpleTask(5, "Заказ");
        boolean expected = true;
        boolean actual = task.matches("Заказ");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void querySimpleTaskFalse() {
        SimpleTask task = new SimpleTask(5, "Заказ");
        boolean expected = false;
        boolean actual = task.matches("Спать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingTopic() {
        Meeting task = new Meeting(5,"Прибыль", "Сделка Года", "22.05 12:00");
        boolean expected = true;
        boolean actual = task.matches("Прибыль");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void queryMeetingProject() {
        Meeting task = new Meeting(5,"Прибыль", "Сделка Года", "22.05 12:00");
        boolean expected = true;
        boolean actual = task.matches("Сделка Года");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void queryMeetingTopicProject() {
        Meeting task = new Meeting(5,"Прибыль", "Прибыль", "22.05 12:00");
        boolean expected = true;
        boolean actual = task.matches("Прибыль");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryMeetingFalse() {
        Meeting task = new Meeting(5,"Прибыль", "Сделка Года", "22.05 12:00");
        boolean expected = false;
        boolean actual = task.matches("Лениться");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryEpicTrue() {
        String[] subtasks = {"Постирать", "Заказать", "Помыть", "Приготовить"};
        Epic task = new Epic(5, subtasks);
        boolean expected = true;
        boolean actual = task.matches("Приготовить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryEpicFalse() {
        String[] subtasks = {"Постирать", "Заказать", "Помыть", "Приготовить"};
        Epic task = new Epic(5, subtasks);
        boolean expected = false;
        boolean actual = task.matches("Лениться");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchSimpleTask() {
        SimpleTask task = new SimpleTask(5, "Дела");
        Todos todos = new Todos();
        todos.add(task);
        Task[] expected = {task};
        Task[] actual = todos.search("Дела");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchEpic() {
        String[] subtasks = { "Постирать", "Помыть", "Отдохнуть" };
        Epic task = new Epic(5, subtasks);
        Todos todos = new Todos();
        todos.add(task);
        Task[] expected = {task};
        Task[] actual = todos.search("Отдохнуть");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMeeting() {
        Meeting task = new Meeting(5, "Стирка", "Генеральная Уборка", "25.05 12:00");
        Todos todos = new Todos();
        todos.add(task);
        Task[] expected = {task};
        Task[] actual = todos.search("Стирка");
        Assertions.assertArrayEquals(expected, actual);
    }
}
