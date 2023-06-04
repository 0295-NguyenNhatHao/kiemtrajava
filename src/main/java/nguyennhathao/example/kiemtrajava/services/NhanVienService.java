package nguyennhathao.example.kiemtrajava.services;


import nguyennhathao.example.kiemtrajava.entity.NhanVien;
import nguyennhathao.example.kiemtrajava.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    public NhanVien getNhanVienById(String id){
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }

    public void addNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void updateNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String id){
        nhanVienRepository.deleteById(id);
    }



}
