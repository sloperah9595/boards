package com.example.kanbas.unitary.services.boards;

import static com.example.kanbas.MakeUltis.makeMockBoard;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.kanbas.models.BoardModel;
import com.example.kanbas.repositories.BoardRepository;
import com.example.kanbas.services.boards.GetBoardByIdService;
import org.junit.jupiter.api.Test;

class GetBoardByIdTest {
    private static final String EXPECTED_NAME = "kanban";
    private static final int BOARD_ID = 1;
    private BoardRepository boardRepository;

    private GetBoardByIdService getBoardByIdService;

    @Test
    void shouldExecuteSuccess() {
        // GIVEN
        this.boardRepository = mock(BoardRepository.class);
        this.getBoardByIdService = new GetBoardByIdService(this.boardRepository);

        // WHEN
        when(this.boardRepository.findById(BOARD_ID)).thenReturn(makeMockBoard());

        // CALL
        BoardModel result = this.getBoardByIdService.execute(BOARD_ID);

        // THEN - VERIFY
        assertNotNull(result);
        assertEquals(EXPECTED_NAME, result.getName());
        verify(this.boardRepository, times(1)).findById(BOARD_ID);
    }

}
