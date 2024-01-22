package uthmhostelmanagementsystem;

public class StudentInformation {

    private static String matriksNo;
    private static String studentName;
    private static String roomNumber;
    private static String feeStatus;

    public String getMatriksNo() {
        return matriksNo;
    }

    public void setMatriksNo(String matriksNo) {
        this.matriksNo = matriksNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        StudentInformation.studentName = studentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        StudentInformation.roomNumber = roomNumber;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        StudentInformation.feeStatus = feeStatus;
    }

    
}
