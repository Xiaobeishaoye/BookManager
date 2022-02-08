package book.manager.service;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SimpleSevice {
    @PostFilter("filterObject.equals('lbwnb')")
    public List<String> test(){
        List<String>list=new LinkedList<>();
        list.add("lbwnb");
        list.add("yyds");
        return list;
    }
}
