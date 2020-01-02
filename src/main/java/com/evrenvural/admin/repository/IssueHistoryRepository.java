package com.evrenvural.admin.repository;

import com.evrenvural.admin.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // İstersen koymayabilirdin extends edilen JpaRepositor'den bu annotation geliyor
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
}
