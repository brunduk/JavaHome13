public class Epic extends Task {
    protected String[] subtasks;

    public String[] getSubtasks() {
        return subtasks;
    }

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String quest : subtasks) {
            if (quest.equals(query)) {
                return true;
            }
        }
        return false;
    }
}
