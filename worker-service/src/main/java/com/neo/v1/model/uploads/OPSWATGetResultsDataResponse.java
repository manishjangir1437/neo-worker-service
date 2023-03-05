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
public class OPSWATGetResultsDataResponse {

    private String progress_percentage;
    private String result;

}
