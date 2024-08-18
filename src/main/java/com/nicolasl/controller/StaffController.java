package com.nicolasl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nicolasl.common.R;
import com.nicolasl.entity.Staff;
import com.nicolasl.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.baomidou.mybatisplus.core.toolkit.ObjectUtils.isNotEmpty;

@Slf4j
@RestController
@RequestMapping("/staff")
public class StaffController {
    
    @Autowired
    private StaffService staffService;
    
    /***
     * 员工登录
     * @param request
     * @param staff
     * @return
     */
    @PostMapping("/login")
    public R<Staff> login(HttpServletRequest request, @RequestBody Staff staff){
        String password = staff.getPassword();
        //password = DigestUtils.md5DigestAsHex(password.getBytes());
        
        //2. 根据页面提交的username查询数据库
        Staff staff1 = staffService.selectByUsername(staff.getUsername());
        
        //3. 如果没有查到
        if(staff1 == null){
            return R.error("登录失败，无此员工");
        }
        
        //4. 密码比对
        if(!staff1.getPassword().equals(password)){
            return R.error("登录失败，密码错误");
        }
        
        //5. 员工是否为已禁用状态
        if(staff1.getStatus() == 0){
            return R.error("员工账号已禁用");
        }
        
        //6. 登录成功，将员工id存入Session并返回成功结果
        request.getSession().setAttribute("staff",staff1.getId());
        return R.success(staff1);
    }

    /***
     * 员工退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的员工id
        request.getSession().removeAttribute("staff");
        return R.success("退出成功！");
    }

    /***
     * 新增员工
     * @param staff
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Staff staff){
        
        //设置初始密码
        staff.setPassword("123456");
        staffService.save(staff);
        return R.success("新增员工成功！");
    }
    
    @GetMapping("/page")
    public R<Page<Staff>> page(int page, int pageSize, String name){
        
        //构造分页构造器
        Page<Staff> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Staff> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(isNotEmpty(name), Staff::getName, name);
        
        staffService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id修改员工信息
     * @param staff
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Staff staff){
        staffService.updateById(staff);
        return R.success("员工信息修改成功！");
    }
    
    @GetMapping("/{id}")
    public R<Staff> selectById(@PathVariable Integer id){
        Staff staff = staffService.getById(id);
        if(staff != null) {
            return R.success(staff);
        }
        return R.error("没有查询到对应员工信息");
    }
}
