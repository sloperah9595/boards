package com.example.kanbas.unitary.services.boards;

import static com.example.kanbas.MakeUltis.makeMockBoard;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.repositories.BoardRepository;
import com.example.kanbas.services.boards.GetBoardAllService;
import java.util.List;
import org.junit.jupiter.api.Test;

class GetBoardAllTest {

    private static final String EXPECTED_NAME = "kanban";
    private BoardRepository boardRepository;

    private GetBoardAllService getBoardAllService;

    @Test
    void shouldExecuteSuccess() {
        // GIVEN
        this.boardRepository = mock(BoardRepository.class);
        this.getBoardAllService = new GetBoardAllService(this.boardRepository);

        // WHEN
        when(this.boardRepository.findAll()).thenReturn(List.of(makeMockBoard()));

        // CALL
        List<BoardModel> result = this.getBoardAllService.execute();

        // THEN - VERIFY
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(EXPECTED_NAME, result.get(0).getName());
        verify(this.boardRepository, times(1)).findAll();
    }

}