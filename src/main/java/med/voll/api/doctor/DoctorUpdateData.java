package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String nome,
        String telefone,
        AddressData endereco
) {
}
