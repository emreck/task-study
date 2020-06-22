package com.emreck.taskstudy.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
//frontende datatable üzerinde kayıtlar gösterilecek.ve db de kaç kayıt gösteriliyorsa o kadar kayıt geri getirilecek.
//bunu implemente etmek için pagenation yapılması gerekiyor.
//bu yüzden frontendin size bilmesi lazım
public class TPage<T>{
    private int number;//kaçıncı sayfa gözüküyor.
    private int size;//kayıtları kaçarlı gösteriyor
    private Sort sort;//kolonu sıralama
    private int totalPages;//toplam kaç sayfa oluştu.10rlı gösterdiğimde 10 sayfa 100 erli gösterdiğimde 1 sayfa gibi.
    private Long totalElements;//toplamda kaç kayıt olduğunu gösterecek.totalpages ile size çarpılıp bulunur ancak son sayfada 3-5 veri olduğunda doğru sonucu vermeyebilir.
    private List<T> content;//dönecek data gösterilecek.

    public void setStat(Page page, List<T> list){
        this.number = page.getNumber();
        this.size =page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content = list;
    }
}
