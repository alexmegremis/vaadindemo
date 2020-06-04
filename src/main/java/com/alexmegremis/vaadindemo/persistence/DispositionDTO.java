package com.alexmegremis.vaadindemo.persistence;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DispositionDTO extends ViewPermissionsEntity {

    private DISPOSITION disposition;

}
