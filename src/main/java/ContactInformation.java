public class ContactInformation {
    String first_name;
    String last_name;
    String phone_number;

    public boolean isEmpty(){
        return first_name.isEmpty() && last_name.isEmpty() && phone_number.isEmpty();
    }

    @Override
    public String toString() {
        if (last_name != null && !last_name.isEmpty()) {
            return "<contact>: " + first_name + ", " + last_name + ", " + phone_number;
        } else {
            return "<contact>: " + first_name + ", " + phone_number;
        }
    }
}
