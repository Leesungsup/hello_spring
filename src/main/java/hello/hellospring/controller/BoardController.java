package hello.hellospring.controller;

import hello.hellospring.entity.Board;
import hello.hellospring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardwrite";
    }
    @PostMapping("/board/writepro")
    public String boardWritepro(Board board)
    {
        boardService.boardWrite(board);
        System.out.println(board.getTitle());
        System.out.println("내용"+board.getContent());
        return "";
    }
    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }
    @GetMapping("/board/view")
    public String boardView(Model model,Integer id){
        model.addAttribute("board",boardService.boardView(id));
        return "boardview";
    }
    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }
}

