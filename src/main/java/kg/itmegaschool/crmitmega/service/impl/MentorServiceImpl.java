package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.mapper.MentorMapper;
import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import kg.itmegaschool.crmitmega.model.request.CreateMentorRequest;
import kg.itmegaschool.crmitmega.repository.MentorRepository;
import kg.itmegaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    @Override
    public MentorDto create(CreateMentorRequest request) {
        Mentor mentor = Mentor
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .salary(Mentor.DEFAULT_SALARY)
                .build();

        mentorRepository.save(mentor);

        return MentorMapper.INSTANCE.toDto(mentor);
    }

    @Override
    public MentorDto find(Long id) {
        return null; // Home Work
    }
}
