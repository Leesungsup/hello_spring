package hello.hellospring.service;

import hello.hellospring.entity.Board;
import hello.hellospring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public void boardWrite(Board board){
        boardRepository.save(board);
    }
    public Page<Board> boardList(Pageable pageable){

        return boardRepository.findAll(pageable);
    }
    public Board boardView(Integer number){
        return boardRepository.findById(number).get();
    }
    public void boardDelete(Integer number){
        boardRepository.deleteById(number);
        return;
    }

}
