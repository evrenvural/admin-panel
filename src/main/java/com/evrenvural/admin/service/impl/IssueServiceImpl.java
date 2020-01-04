package com.evrenvural.admin.service.impl;

import com.evrenvural.admin.dto.IssueDto;
import com.evrenvural.admin.entity.Issue;
import com.evrenvural.admin.repository.IssueRepository;
import com.evrenvural.admin.service.IssueService;
import com.evrenvural.admin.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    // @Autowired
    // private IssueRepository issueReposistory; // Normalde bu şekilde autowired edilir fakat best practice'e göre constructor'da autowired etmek daha sağlıklı

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Autowired // Yazmasak da olur (Yeni sürüm ile)
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {

        if (issueDto.getDate() == null) {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }

        Issue issue = modelMapper.map(issueDto, Issue.class);

        issue = issueRepository.save(issue);

        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);

        TPage<IssueDto> page = new TPage<IssueDto>();

        IssueDto[] issuesDto = modelMapper.map(data.getContent(), IssueDto[].class);

        page.setStat(data, Arrays.asList(issuesDto));

        return page;
    }

    @Override
    public Boolean delete(IssueDto issueDto) {
        return null;
    }
}
