package hello.hellospring.service;

import hello.hellospring.entity.Board;
import hello.hellospring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public void boardWrite(Board board){
        boardRepository.save(board);
    }
    public List<Board> boardList(){
        return boardRepository.findAll();
    }
    public Board boardView(Integer number){
        return boardRepository.findById(number).get();
    }
    public void boardDelete(Integer number){
        boardRepository.deleteById(number);
        return;
    }

}
