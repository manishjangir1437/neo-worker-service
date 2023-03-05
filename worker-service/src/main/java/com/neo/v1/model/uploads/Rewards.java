package com.neo.v1.model.uploads;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rewards {

    private java.math.BigDecimal id;

    private String referenceId;

    private String s3Location;

    private String sha256Checksum;

    private java.math.BigDecimal categoryId;

    private String documentType;

    private String scanStatus;
}
