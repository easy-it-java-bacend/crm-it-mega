package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.request.CreateMentorRequest;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {
    MentorDto create(CreateMentorRequest request);
    MentorDto find(Long id);
}
