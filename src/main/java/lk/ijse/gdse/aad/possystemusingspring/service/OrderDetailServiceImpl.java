//package lk.ijse.gdse.aad.possystemusingspring.service;
//
//import jakarta.transaction.Transactional;
//import lk.ijse.gdse.aad.possystemusingspring.dao.OrderDetailDao;
//import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDetailDto;
//import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class OrderDetailServiceImpl implements OrderDetailService {
//    @Autowired
//    private OrderDetailDao orderDetailDao;
//    @Autowired
//    private Mapping mapping;
//    @Override
//    public void saveOrderDetails(OrderDetailDto orderDetailDto) {
//        orderDetailDao.save(mapping.convertToEntity(orderDetailDto));
//    }
//}
