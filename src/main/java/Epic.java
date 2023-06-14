public class Epic extends Task {
    protected String[] subtasks;

    public String[] getSubtasks() {
        return subtasks;
    }

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }
  //  @Override
  //  public boolean matches(String query) {
  //      String[] tmp = new String[subtasks.length + 1];
  //      for (int i = 0; i < subtasks.length; i++) {
  //          tmp[i] = subtasks[i];
  //          if (subtasks[subtasks.length].contains(query)) ;
  //          return true;
  //      }
   //     return false;
   // }
    @Override
    public boolean matches(String query) {
        for (String quest : subtasks) {
            if (quest == query) {
                return true;
            }
        }
        return false;
    }
}
