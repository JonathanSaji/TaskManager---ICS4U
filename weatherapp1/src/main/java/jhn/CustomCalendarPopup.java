package jhn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.YearMonth;

public class CustomCalendarPopup extends JFrame {

    private LocalDate selectedDate;
    private JLabel monthLabel;
    private JPanel calendarPanel;
    private YearMonth currentMonth;
    private JFrame parentFrame;
    private Weather weather;

    public CustomCalendarPopup(JFrame parentFrame, Weather weather) {
        this.parentFrame = parentFrame;
        this.currentMonth = YearMonth.now();
        this.weather = weather;

        createAndShowDialog();
    }

    private void createAndShowDialog() {

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        JLabel prevButton = new JLabel("<");
        JLabel nextButton = new JLabel(">");
        monthLabel = new JLabel();

        prevButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        prevButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        updateMonthLabel();

        prevButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMonth = currentMonth.minusMonths(1);
                updateCalendar();
            }
        });

        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMonth = currentMonth.plusMonths(1);
                updateCalendar();
            }
        });

        topPanel.add(prevButton);
        topPanel.add(monthLabel);
        topPanel.add(nextButton);

        calendarPanel = new JPanel(new GridLayout(0, 7));
        updateCalendar();

        add(topPanel, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(500, 500));
        pack();
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    private void updateMonthLabel() {
        monthLabel.setText(currentMonth.getMonth() + " " + currentMonth.getYear());
    }

    private void updateCalendar() {
        calendarPanel.removeAll();
        updateMonthLabel();

        String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        for (String day : days) {
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        LocalDate firstDay = currentMonth.atDay(1);
        int start = firstDay.getDayOfWeek().getValue() % 7;
        for (int i = 0; i < start; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= currentMonth.lengthOfMonth(); day++) {
            final int d = day;
            JLabel label = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectedDate = currentMonth.atDay(d);

                    if (weather.isThereTemp(selectedDate, 0)) {
                        WeatherApp.getMenu().closePanel();
                        new DisplayWeather(parentFrame, weather, selectedDate);
                        dispose();
                    }

                }
            });

            calendarPanel.add(label);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }
}
