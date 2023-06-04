package nguyennhathao.example.kiemtrajava.repository;


import nguyennhathao.example.kiemtrajava.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, Long> {
}
