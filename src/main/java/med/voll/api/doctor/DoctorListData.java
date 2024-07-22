package med.voll.api.doctor;

public record DoctorListData(
        Long id,
        String nome,
        String email,
        String crm,
        Specialty especialidade
) {
    public DoctorListData(Doctor doctor) {
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
