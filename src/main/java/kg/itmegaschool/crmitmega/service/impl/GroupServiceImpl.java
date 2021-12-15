package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.exceptions.GroupNotFoundException;
import kg.itmegaschool.crmitmega.mapper.GroupMapper;
import kg.itmegaschool.crmitmega.model.dto.GroupDto;
import kg.itmegaschool.crmitmega.model.request.CreateGroupRequest;
import kg.itmegaschool.crmitmega.repository.GroupRepository;
import kg.itmegaschool.crmitmega.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public GroupDto find(Long id) {
        return GroupMapper.INSTANCE
                .toDto(groupRepository.findById(id)
                        .orElseThrow(() -> new GroupNotFoundException("Group with id=" + id + " not found.")));
    }

    @Override
    public GroupDto create(CreateGroupRequest request) {


        return null;
    }
}
