package med.voll.api.doctor;

import med.voll.api.address.AddressData;

public record DoctorData(String nome, String email, String crm, Specialty especialidade, AddressData endereco) {
}
