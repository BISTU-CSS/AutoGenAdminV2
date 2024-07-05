package com.autogen.service.atgInterface;
//生成逻辑

import com.autogen.dao.entity.cp1.Chaptre1input;
import com.autogen.dao.entity.cp2.Chaptre2input;
import com.autogen.dao.entity.cp3.Chaptre3input;
import com.autogen.dao.entity.cp4.Chaptre4input;
import com.autogen.dao.entity.cp5.Chaptre5input;
import com.autogen.dao.entity.cp6.Chaptre6input;
import com.autogen.dao.entity.cp7.Chaptre7input;
import com.autogen.dao.entity.input.QuestionNaire;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;

public interface AutoGenerator {
    /**
     * 生成第一章
     * @param input 第一章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_one_generator(Chaptre1input input) throws IOException;
    /**
     * 生成第二章
     * @param input 第二章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_two_generator(Chaptre2input input) throws IOException;
    /**
     * 生成第三章
     * @param input 第三章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_three_generator(Chaptre3input input) throws IOException;
    /**
     * 生成第四章
     * @param input 第四章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_four_generator(Chaptre4input input) throws IOException;
    /**
     * 生成第五章
     * @param input 第五章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_five_generator(Chaptre5input input, QuestionNaire questionNaire) throws IOException;
    /**
     * 生成第六章
     * @param input 第六章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_six_generator(Chaptre6input input) throws IOException;
    /**
     * 生成第七章
     * @param input 第七章用到的变量
     * @return
     * @throws IOException
     */
    XWPFDocument chapter_seven_generator(Chaptre7input input) throws IOException;
}
