package uz.pdp.warehouseapp.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.AttachmentContent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    Optional<AttachmentContent> findByAttachmentId(UUID id);

//    List<AttachmentContent> findAllByAttachmentId(List<UUID> ids);
}
