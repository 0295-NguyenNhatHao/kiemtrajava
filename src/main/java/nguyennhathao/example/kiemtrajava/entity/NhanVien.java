package nguyennhathao.example.kiemtrajava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "NhanVien")
@Data
public class NhanVien {
    @Id
    @NotBlank(message = "Truong nay khong duoc phep bo trong")
    @Length(min = 0,max=3)
    @Column(name="Ma_NV")
    private String Ma_NV;
    @Column(name = "Ten_NV")
    @Length(max=100)
    @NotBlank(message = "Truong nay ko duoc phep bo trong")
    private String Ten_NV;
    @Column(name="Phai")
    @Length(max=3)
    private String Phai;
    @Column(name="Noi_Sinh")
    @Length(max=200)
    private String Noi_Sinh;
    @Column(name = "Luong")
    private int Luong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;



}
