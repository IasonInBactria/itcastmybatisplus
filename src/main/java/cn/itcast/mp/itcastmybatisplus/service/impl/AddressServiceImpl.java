package cn.itcast.mp.itcastmybatisplus.service.impl;

import cn.itcast.mp.itcastmybatisplus.pojo.Address;
import cn.itcast.mp.itcastmybatisplus.mapper.AddressMapper;
import cn.itcast.mp.itcastmybatisplus.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swj
 * @since 2023-09-18
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
