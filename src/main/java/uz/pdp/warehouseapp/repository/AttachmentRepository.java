package uz.pdp.warehouseapp.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Attachment;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

}
