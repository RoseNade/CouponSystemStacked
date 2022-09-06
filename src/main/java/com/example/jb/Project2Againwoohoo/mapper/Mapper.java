package com.example.jb.Project2Againwoohoo.mapper;

import java.util.List;

public interface Mapper <DAO, DPayloadDTO>{
    DAO toDao(DPayloadDTO dPayloadDTOd);

    DPayloadDTO toPayloadDTO(DAO dao);

    List<DAO> toDaoList(List<DPayloadDTO> dPayloadDTOList);

    List<DPayloadDTO> toPayloadDTOList(List<DAO> daoList);
}
