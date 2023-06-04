package nguyennhathao.example.kiemtrajava.repository;



import nguyennhathao.example.kiemtrajava.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}
