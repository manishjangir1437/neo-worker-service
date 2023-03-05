package com.neo.v1.model;

import com.neo.v1.model.uploads.OPSWATGetResultsDataResponse;
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
public class OPSWATGetResultsResponse {

    private OPSWATGetResultsDataResponse process_info;

}
