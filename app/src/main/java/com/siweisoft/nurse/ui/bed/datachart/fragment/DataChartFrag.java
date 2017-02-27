package com.siweisoft.nurse.ui.bed.datachart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.fragment.BaseUIWithOutTitleFrag;
import com.siweisoft.lib.base.ui.interf.OnFinishListener;
import com.siweisoft.lib.constant.ValueConstant;
import com.siweisoft.lib.util.GsonUtil;
import com.siweisoft.lib.base.ui.netadapter.UINetAdapter;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.ui.bed.data.bean.resbean.TitleDataResBean;
import com.siweisoft.nurse.ui.bed.datachart.bean.reqbean.DataChartReqBean;
import com.siweisoft.nurse.ui.bed.datachart.bean.resbean.DataChartListResBean;
import com.siweisoft.nurse.ui.bed.datachart.bean.resbean.DataChartResBean;
import com.siweisoft.nurse.ui.bed.datachart.ope.DataChartDAOpe;
import com.siweisoft.nurse.ui.bed.datachart.ope.DataChartUIOpe;
import com.siweisoft.nurse.ui.bed.patient.ope.PatientAdditionDAOpe;

import java.util.ArrayList;
import java.util.List;

import com.siweisoft.lib.lecho.lib.hellocharts.animation.ChartAnimationListener;
import com.siweisoft.lib.lecho.lib.hellocharts.gesture.ZoomType;
import com.siweisoft.lib.lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import com.siweisoft.lib.lecho.lib.hellocharts.model.Axis;
import com.siweisoft.lib.lecho.lib.hellocharts.model.AxisValue;
import com.siweisoft.lib.lecho.lib.hellocharts.model.Line;
import com.siweisoft.lib.lecho.lib.hellocharts.model.LineChartData;
import com.siweisoft.lib.lecho.lib.hellocharts.model.PointValue;
import com.siweisoft.lib.lecho.lib.hellocharts.model.ValueShape;
import com.siweisoft.lib.lecho.lib.hellocharts.model.Viewport;
import com.siweisoft.lib.lecho.lib.hellocharts.util.ChartUtils;
import com.siweisoft.lib.lecho.lib.hellocharts.view.Chart;
import com.siweisoft.lib.lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by ${viwmox} on 2016-11-28.
 */
public class DataChartFrag extends BaseUIWithOutTitleFrag {


    private LineChartData data;
    private int numberOfLines = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 12;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLines = true;
    private boolean hasPoints = true;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = false;
    private boolean hasLabels = true;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = false;
    private boolean pointsHaveDifferentColor;


    DataChartUIOpe dataChartUIOpe;

    NurseNetOpe dataChartNetOpe;

    DataChartDAOpe dataChartDAOpe;

    PatientAdditionDAOpe patientAdditionDAOpe;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()==null || getArguments().getSerializable(ValueConstant.DATA_DATA)==null || getArguments().getSerializable(ValueConstant.DATA_DATA2)==null){
            return;
        }
        patientAdditionDAOpe = (PatientAdditionDAOpe) getArguments().getSerializable(ValueConstant.DATA_DATA2);
        dataChartDAOpe= new DataChartDAOpe(activity);
        dataChartDAOpe.setTitleDataResBean((TitleDataResBean) getArguments().getSerializable(ValueConstant.DATA_DATA));
        dataChartUIOpe= new DataChartUIOpe(activity,getView());
        dataChartNetOpe = new NurseNetOpe(activity);
        getData(null);
    }

    DataChartListResBean dataChartListResBean;

    public void getData(OnFinishListener onFinishListener){
        DataChartReqBean reqBean = new DataChartReqBean();
        reqBean.setGroupid(dataChartDAOpe.getTitleDataResBean().getGroupid());
        reqBean.setSignid(dataChartDAOpe.getTitleDataResBean().getSignid());
        reqBean.setZyh(patientAdditionDAOpe.getPatientBedResBean().get住院号());
        dataChartNetOpe.getRecordDetailData(reqBean, new UINetAdapter(activity) {
            @Override
            public void onNetWorkResult(boolean success, Object o) {
                if(success){
                     dataChartListResBean = GsonUtil.getInstance().fromJson(o.toString(),DataChartListResBean.class);
                    dataChartUIOpe.getChart().setOnValueTouchListener(new ValueTouchListener());
                    //generateValues();
                    generateData(dataChartListResBean.getData());
                    dataChartUIOpe.getChart().setViewportCalculationEnabled(false);
                    resetViewport();
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reset) {
            reset();
            generateData(dataChartListResBean.getData());
            return true;
        }
        if (id == R.id.action_add_line) {
            addLineToData();
            return true;
        }
        if (id == R.id.action_toggle_lines) {
            toggleLines();
            return true;
        }
        if (id == R.id.action_toggle_points) {
            togglePoints();
            return true;
        }
        if (id == R.id.action_toggle_cubic) {
            toggleCubic();
            return true;
        }
        if (id == R.id.action_toggle_area) {
            toggleFilled();
            return true;
        }
        if (id == R.id.action_point_color) {
            togglePointColor();
            return true;
        }
        if (id == R.id.action_shape_circles) {
            setCircles();
            return true;
        }
        if (id == R.id.action_shape_square) {
            setSquares();
            return true;
        }
        if (id == R.id.action_shape_diamond) {
            setDiamonds();
            return true;
        }
        if (id == R.id.action_toggle_labels) {
            toggleLabels();
            return true;
        }
        if (id == R.id.action_toggle_axes) {
            toggleAxes();
            return true;
        }
        if (id == R.id.action_toggle_axes_names) {
            toggleAxesNames();
            return true;
        }
        if (id == R.id.action_animate) {
            prepareDataAnimation();
            dataChartUIOpe.getChart().startDataAnimation();
            return true;
        }
        if (id == R.id.action_toggle_selection_mode) {
            toggleLabelForSelected();

            Toast.makeText(getActivity(),
                    "Selection mode set to " + dataChartUIOpe.getChart().isValueSelectionEnabled() + " select any point.",
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_toggle_touch_zoom) {
            dataChartUIOpe.getChart().setZoomEnabled(!dataChartUIOpe.getChart().isZoomEnabled());
            Toast.makeText(getActivity(), "IsZoomEnabled " + dataChartUIOpe.getChart().isZoomEnabled(), Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_zoom_both) {
            dataChartUIOpe.getChart().setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
            return true;
        }
        if (id == R.id.action_zoom_horizontal) {
            dataChartUIOpe.getChart().setZoomType(ZoomType.HORIZONTAL);
            return true;
        }
        if (id == R.id.action_zoom_vertical) {
            dataChartUIOpe.getChart().setZoomType(ZoomType.VERTICAL);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void generateValues() {
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }
    }

    private void reset() {
        numberOfLines = 1;

        hasAxes = true;
        hasAxesNames = true;
        hasLines = true;
        hasPoints = true;
        shape = ValueShape.CIRCLE;
        isFilled = false;
        hasLabels = false;
        isCubic = false;
        hasLabelForSelected = false;
        pointsHaveDifferentColor = false;

        dataChartUIOpe.getChart().setValueSelectionEnabled(hasLabelForSelected);
        resetViewport();
    }

    private void resetViewport() {
        // Reset viewport height range to (0,100)
        final Viewport v = new Viewport(dataChartUIOpe.getChart().getMaximumViewport());
        v.bottom = 0;
        v.top = 100;
        v.left = 0;
        v.right = numberOfPoints - 1;
        dataChartUIOpe.getChart().setMaximumViewport(v);
        dataChartUIOpe.getChart().setCurrentViewport(v);
    }

    private void generateData(ArrayList<DataChartResBean> resBeen) {

        List<Line> lines = new ArrayList<Line>();
        List<PointValue> values = new ArrayList<PointValue>();

        for(int m=0;m<resBeen.size();m++){
            values.add(new PointValue(m,resBeen.get(m).getValue()));
        }

        Line line = new Line(values);
        line.setColor(ChartUtils.COLORS[0]);
        line.setShape(shape);
        line.setCubic(isCubic);
        line.setFilled(isFilled);
        line.setHasLabels(hasLabels);
        line.setHasLabelsOnlyForSelected(hasLabelForSelected);
        line.setHasLines(hasLines);
        line.setHasPoints(hasPoints);
        if (pointsHaveDifferentColor){
            //line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
        }
        lines.add(line);

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            if (hasAxesNames) {
                axisX.setName(dataChartDAOpe.getTitleDataResBean().getSignname());
                axisY.setName("");
            }
            axisX.setAutoGenerated(false);
            axisX.setHasLines(true);
            List<AxisValue> list = new ArrayList<>();
            for(int i=0;i<resBeen.size();i++){
                AxisValue axisValue = new AxisValue(i);
                list.add(axisValue);
            }
            axisX.setValues(list);
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        dataChartUIOpe.getChart().setLineChartData(data);

    }

    /**
     * Adds lines to data, after that data should be set again with
     * {@link LineChartView#setLineChartData(LineChartData)}. Last 4th line has non-monotonically x values.
//     */
    private void addLineToData() {
        if (data.getLines().size() >= maxNumberOfLines) {
            Toast.makeText(getActivity(), "Samples app uses max 4 lines!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            ++numberOfLines;
        }

        generateData(dataChartListResBean.getData());
    }

    private void toggleLines() {
        hasLines = !hasLines;

        generateData(dataChartListResBean.getData());
    }

    private void togglePoints() {
        hasPoints = !hasPoints;

        generateData(dataChartListResBean.getData());
    }

    private void toggleCubic() {
        isCubic = !isCubic;

        generateData(dataChartListResBean.getData());

        if (isCubic) {
            // It is good idea to manually set a little higher max viewport for cubic lines because sometimes line
            // go above or below max/min. To do that use Viewport.inest() method and pass negative value as dy
            // parameter or just set top and bottom values manually.
            // In this example I know that Y values are within (0,100) range so I set viewport height range manually
            // to (-5, 105).
            // To make this works during animations you should use Chart.setViewportCalculationEnabled(false) before
            // modifying viewport.
            // Remember to set viewport after you call setLineChartData().
            final Viewport v = new Viewport(dataChartUIOpe.getChart().getMaximumViewport());
            v.bottom = -5;
            v.top = 105;
            // You have to set max and current viewports separately.
            dataChartUIOpe.getChart().setMaximumViewport(v);
            // I changing current viewport with animation in this case.
            dataChartUIOpe.getChart().setCurrentViewportWithAnimation(v);
        } else {
            // If not cubic restore viewport to (0,100) range.
            final Viewport v = new Viewport(dataChartUIOpe.getChart().getMaximumViewport());
            v.bottom = 0;
            v.top = 100;

            // You have to set max and current viewports separately.
            // In this case, if I want animation I have to set current viewport first and use animation listener.
            // Max viewport will be set in onAnimationFinished method.
            dataChartUIOpe.getChart().setViewportAnimationListener(new ChartAnimationListener() {

                @Override
                public void onAnimationStarted() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationFinished() {
                    // Set max viewpirt and remove listener.
                    dataChartUIOpe.getChart().setMaximumViewport(v);
                    dataChartUIOpe.getChart().setViewportAnimationListener(null);

                }
            });
            // Set current viewpirt with animation;
            dataChartUIOpe.getChart().setCurrentViewportWithAnimation(v);
        }

    }

    private void toggleFilled() {
        isFilled = !isFilled;

        generateData(dataChartListResBean.getData());
    }

    private void togglePointColor() {
        pointsHaveDifferentColor = !pointsHaveDifferentColor;

        generateData(dataChartListResBean.getData());
    }

    private void setCircles() {
        shape = ValueShape.CIRCLE;

        generateData(dataChartListResBean.getData());
    }

    private void setSquares() {
        shape = ValueShape.SQUARE;

        generateData(dataChartListResBean.getData());
    }

    private void setDiamonds() {
        shape = ValueShape.DIAMOND;

        generateData(dataChartListResBean.getData());
    }

    private void toggleLabels() {
        hasLabels = !hasLabels;

        if (hasLabels) {
            hasLabelForSelected = false;
            dataChartUIOpe.getChart().setValueSelectionEnabled(hasLabelForSelected);
        }

        generateData(dataChartListResBean.getData());
    }

    private void toggleLabelForSelected() {
        hasLabelForSelected = !hasLabelForSelected;

        dataChartUIOpe.getChart().setValueSelectionEnabled(hasLabelForSelected);

        if (hasLabelForSelected) {
            hasLabels = false;
        }

        generateData(dataChartListResBean.getData());
    }

    private void toggleAxes() {
        hasAxes = !hasAxes;

        generateData(dataChartListResBean.getData());
    }

    private void toggleAxesNames() {
        hasAxesNames = !hasAxesNames;

        generateData(dataChartListResBean.getData());
    }

    /**
     * To animate values you have to change targets values and then call {@link Chart#startDataAnimation()}
     * method(don't confuse with View.animate()). If you operate on data that was set before you don't have to call
     * {@link LineChartView#setLineChartData(LineChartData)} again.
     */
    private void prepareDataAnimation() {
        for (Line line : data.getLines()) {
            for (PointValue value : line.getValues()) {
                // Here I modify target only for Y values but it is OK to modify X targets as well.
                value.setTarget(value.getX(), (float) Math.random() * 100);
            }
        }
    }

    private class ValueTouchListener implements LineChartOnValueSelectListener {

        @Override
        public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
            Toast.makeText(getActivity(), "Selected: " + value, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onValueDeselected() {
            // TODO Auto-generated method stub

        }

    }

    @Override
    public int getContainView() {
        return R.layout.fragment_line_chart;
    }
}
