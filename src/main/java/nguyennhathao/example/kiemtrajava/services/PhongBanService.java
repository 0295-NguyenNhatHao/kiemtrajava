package nguyennhathao.example.kiemtrajava.services;


import nguyennhathao.example.kiemtrajava.entity.PhongBan;
import nguyennhathao.example.kiemtrajava.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    public PhongBan getPhongBanById(Long id){
        Optional<PhongBan> optionalCategory = phongBanRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category not found");
        }
    }
    public PhongBan savePhongBan(PhongBan phongBan){
        return phongBanRepository.save(phongBan);
    }
    /*public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
*/

}
