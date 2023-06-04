package nguyennhathao.example.kiemtrajava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name= "PhongBan")
@Data
public class PhongBan {
    @Id
    @Column(name = "Ma_Phong")
    @NotBlank(message = "Truong nay khong duoc bo trong")
    @Length(max=2)
    private String Ma_Phong;
    @Column(name = "Ten_Phong")
    @NotBlank(message = "Truong nay khong duoc bo trong")
    @Length(max=30)
    private String Ten_Phong;
    @OneToMany(mappedBy = "phongBan",fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;
}
